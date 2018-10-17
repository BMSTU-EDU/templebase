package ru.bmstu.templebase.model;

public enum TempleFields {
    ID("id"),
    NAME("name");

    private String fieldName;

    TempleFields(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return fieldName;
    }

    public static TempleFields fromFieldName(String fieldName) {
        for (TempleFields f: TempleFields.values()) {
            if (fieldName.equals(f.toString())) {
                return f;
            }
        }
        return null;
    }
}
