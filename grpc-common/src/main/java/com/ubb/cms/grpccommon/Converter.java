package com.ubb.cms.grpccommon;

import com.google.protobuf.Timestamp;
import com.ubb.cms.generated.ConferenceDto;
import com.ubb.cms.generated.EditionDto;
import com.ubb.cms.generated.UserDto;
import com.ubb.cms.model.Conference;
import com.ubb.cms.model.Edition;
import com.ubb.cms.model.User;

import java.time.Instant;
import java.util.Date;

/**
 * @author Marius Adam
 */
public class Converter {
    public static UserDto toDto(User user) {
        return UserDto.newBuilder()
                .setId(user.getId())
                .setName(user.getName())
                .setPassword(user.getPassword())
                .setSurname(user.getSurname())
                .setTag(user.getTag())
                .setEmail(user.getEmail())
                .build();
    }

    public static EditionDto toDto(Edition edition) {
        return EditionDto.newBuilder()
                .setId(edition.getId())
                .setName(edition.getName())
                .setConference(toDto(edition.getConference()))
                .setBeginningDate(toDto(edition.getBeginningDate()))
                .setEndingDate(toDto(edition.getEndingDate()))
                .setFinalDeadline(toDto(edition.getFinalDeadline()))
                .setPaperSubmissionDeadline(toDto(edition.getPaperSubmissionDeadline()))
                .build();
    }

    public static Timestamp toDto(Date date) {
        Instant instant = date.toInstant();
        return Timestamp.newBuilder()
                .setNanos(instant.getNano())
                .setSeconds(instant.getEpochSecond())
                .build();
    }

    public static ConferenceDto toDto(Conference conference) {
        return ConferenceDto.newBuilder()
                .setId(conference.getId())
                .setName(conference.getName())
                .build();
    }

    public static Edition toPojo(EditionDto value) {
        return new Edition(
                Math.toIntExact(value.getId()),
                toPojo(value.getConference()),
                toPojo(value.getBeginningDate()),
                toPojo(value.getEndingDate()),
                value.getName(),
                toPojo(value.getPaperSubmissionDeadline()),
                toPojo(value.getFinalDeadline())
        );
    }

    public static Conference toPojo(ConferenceDto conferenceDto) {
        return new Conference(
                Math.toIntExact(conferenceDto.getId()),
                conferenceDto.getName()
        );
    }

    public static Date toPojo(Timestamp instantDto) {
        Instant instant = Instant.ofEpochSecond(instantDto.getSeconds(), instantDto.getNanos());
        return Date.from(instant);
    }

    public static User toPojo(UserDto value) {
        return new User(
                Math.toIntExact(value.getId()),
                value.getUsername(),
                value.getPassword(),
                value.getEmail(),
                value.getName(),
                value.getSurname(),
                value.getTag()
        );
    }
}
