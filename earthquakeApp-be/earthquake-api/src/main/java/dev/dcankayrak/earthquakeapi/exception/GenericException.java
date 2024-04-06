package dev.dcankayrak.earthquakeapi.exception;

import dev.dcankayrak.earthquakeapi.entity.enums.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class GenericException extends RuntimeException {
    private ErrorEnum errorEnum;
}
