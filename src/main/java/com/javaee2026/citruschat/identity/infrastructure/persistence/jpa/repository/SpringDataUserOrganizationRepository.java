package com.javaee2026.citruschat.identity.infrastructure.persistence.jpa.repository;

import com.javaee2026.citruschat.identity.infrastructure.persistence.jpa.entity.UserOrganizationJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface SpringDataUserOrganizationRepository extends JpaRepository<UserOrganizationJpaEntity, UUID> {

	@Query("""
			    SELECT CASE WHEN COUNT(uo) > 0 THEN true ELSE false END
			    FROM UserOrganizationJpaEntity uo
			    JOIN uo.position p
			    JOIN UserJpaEntity u ON u.id = uo.userId
			    WHERE uo.userId = :userId
			      AND u.deletedAt IS NULL
			      AND (
			          UPPER(p.name) = :adminNameUpper
			          OR p.hierarchyLevel >= :adminLevel
			      )
			""")
	boolean hasAdminAccess(@Param("userId") Long userId, @Param("adminNameUpper") String adminNameUpper,
			@Param("adminLevel") Integer adminLevel);

	boolean existsAdminAccessByUserId(UUID userId, String adminName, Integer adminLevel);
}
