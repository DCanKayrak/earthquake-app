package dev.dcankayrak.earthquakeapi.utils.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Apis {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Earthquake {
        public static final String BASE_URL = "/earthquake";
    }
}
