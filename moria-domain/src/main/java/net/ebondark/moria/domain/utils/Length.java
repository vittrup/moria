package net.ebondark.moria.domain.utils;

/**
 * Interface with entity's attributes length.
 */
public interface Length {

    int STRING_SHORT = 10;
    int STRING_STD = 50;
    int STRING_LONG = 255;
    int STRING_VERYLONG = 1000;
    int STRING_MAXLEN = 4096;

    int PASS_HASH = 40;
    int PASS_SALT = 8;
}
