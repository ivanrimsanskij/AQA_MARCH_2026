package org.prog.session6;

import java.util.Objects;

public class Ph {
    public String color;
    public String brand;

    @Override
    public boolean equals(Object obj) {

        if (brand == null || color == null) {
            throw new RuntimeException();
        }

        if (obj instanceof Ph) {
            Ph phone = (Ph) obj;

            return Objects.equals(phone.color, this.color) &&
                    Objects.equals(phone.brand, this.brand);
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (brand == null || color == null) {
            throw new RuntimeException();
        }
        return Objects.hashCode(color + brand);
    }
}

