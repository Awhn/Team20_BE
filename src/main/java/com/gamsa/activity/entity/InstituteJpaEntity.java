package com.gamsa.activity.entity;

import com.gamsa.activity.domain.Institute;
import com.gamsa.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "Institute")
public class InstituteJpaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "institute_id")
    private Long instituteId;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "location", length = 255)
    private String location;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sido_gungu_code", referencedColumnName = "sido_gungu_code")
    private DistrictJpaEntity sidoGungu;

    @Column(name = "phone", length = 12)
    private String phone;

    public static InstituteJpaEntity from(Institute institute) {
        return InstituteJpaEntity.builder()
            .instituteId(institute.getInstituteId())
            .name(institute.getName())
            .location(institute.getLocation())
            .latitude(institute.getLatitude())
            .longitude(institute.getLongitude())
            .sidoGungu(DistrictJpaEntity.from(institute.getSidoGungu()))
            .phone(institute.getPhone())
            .build();
    }

    public Institute toModel() {
        return Institute.builder()
            .instituteId(instituteId)
            .name(name)
            .location(location)
            .latitude(latitude)
            .longitude(longitude)
            .sidoGungu(sidoGungu.toModel())
            .phone(phone)
            .build();
    }
}
