package com.one.portfoilo;

import com.google.common.base.CaseFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import jakarta.persistence.metamodel.EntityType;
import jakarta.transaction.Transactional;
import org.assertj.core.util.introspection.CaseFormatUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DatabaseCleanup implements InitializingBean {
    @PersistenceContext
    private EntityManager em;

    private List<String> tableNames;

    @Override
    public void afterPropertiesSet() throws Exception {
        final Set<EntityType<?>> entities = em.getMetamodel().getEntities();
        // 엔티티 매니저에서 JPA 엔티티를 모두 가져온다
        /*
            엔티티가 Stream을 돌면서
            지금 Entity/Table 어노테이션이 붇어있는지 확인해서
            없다면 그 테이블의 이름을 수정해준다
         */
        tableNames = entities.stream()
                .filter(e -> isEntity(e) && hasTableAnnotaion(e))
                .map(e -> e.getJavaType().getAnnotation(Table.class).name())
                .collect(Collectors.toList());

        final List<String> entityNames = entities.stream()
                .filter(e -> isEntity(e) && !hasTableAnnotaion(e))
                .map(e -> CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, e.getName()))
                .toList();

    }

    private boolean isEntity(final EntityType<?> e) {
        return null != e.getJavaType().getAnnotation(Entity.class);
    }

    private boolean hasTableAnnotaion(final EntityType<?> e) {
        return null != e.getJavaType().getAnnotation(Table.class);
    }

    @Transactional
    public void execute() {
        // 현재 트랜잭션에 대해 flush를 호출하여 데이터베이스와의 동기화를 완료
        em.flush();

        // MySQL에서 외래키 제약을 비활성화하는 명령어
        em.createNativeQuery("SET foreign_key_checks = 0").executeUpdate();

        for (final String tableName : tableNames) {
            // 각 테이블을 TRUNCATE하여 데이터 삭제
            em.createNativeQuery("TRUNCATE TABLE " + tableName).executeUpdate();

            // 테이블의 AUTO_INCREMENT 값을 1로 재설정
            em.createNativeQuery("ALTER TABLE " + tableName + " AUTO_INCREMENT = 1").executeUpdate();
        }

        // 외래키 제약을 다시 활성화
        em.createNativeQuery("SET foreign_key_checks = 1").executeUpdate();
    }
}
