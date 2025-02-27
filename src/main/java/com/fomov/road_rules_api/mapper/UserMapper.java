package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.RegistrationRequestDTO;
import com.fomov.road_rules_api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(RegistrationRequestDTO registrationRequestDTO);

    RegistrationRequestDTO toRegistrationRequestDTO(User user);
}