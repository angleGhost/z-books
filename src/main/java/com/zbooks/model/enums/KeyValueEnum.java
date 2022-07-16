package com.zbooks.model.enums;

import org.springframework.util.Assert;

import java.util.stream.Stream;

public interface KeyValueEnum<K, V> {

    /**
     * Gets enum key.
     *
     * @return enum key
     */
    K getKey();

    /**
     * Gets enum value.
     *
     * @return enum value
     */
    V getValue();

    /**
     * Converts key and value to corresponding enum.
     *
     * @param enumType enum type
     * @param key      database key
     * @param value    database value
     * @param <K>      key generic
     * @param <V>      value generic
     * @param <E>      enum generic
     *
     * @return corresponding enum
     */
    static <K, V, E extends Enum<E> & KeyValueEnum<K, V>> E valueToEnum(Class<E> enumType, K key, V value) {
        Assert.notNull(enumType, "enum type must not be null");
        Assert.notNull(value, "value must not be null");
        Assert.isTrue(enumType.isEnum(), "type must be an enum type");

        return Stream.of(enumType.getEnumConstants())
                .filter(item -> item.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown database key" + key + "and value: " + value));
    }
}