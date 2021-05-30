package springboot.domain;

import springboot.domain.entity.UserStats;

public enum Attribute {
    STR("СИЛ"),
    DEX("ЛВК"),
    CON("ВНС"),
    INT("ИНТ");

    private static final String UNKNOWN_ATTRIBUTE = "Unknown attribute";
    private String code;

    Attribute(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name();
    }

    public void incrementUserStats(UserStats userStats, int incrementValue) {
        switch (this) {
            case INT:
                userStats.incrementIntelligent(incrementValue);
                break;
            case CON:
                userStats.incrementConstitution(incrementValue);
                break;
            case DEX:
                userStats.incrementDexterity(incrementValue);
                break;
            case STR:
                userStats.incrementStrength(incrementValue);
                break;
            default:
                throw new RuntimeException(UNKNOWN_ATTRIBUTE);
        }
    }

    public boolean isConditionSatisfied(UserStats userStats, int attributeValue) {
        switch (this) {
            case CON:
                return userStats.getConstitution() == attributeValue;
            case DEX:
                return userStats.getDexterity() == attributeValue;
            case INT:
                return userStats.getIntelligent() == attributeValue;
            case STR:
                return userStats.getStrength() == attributeValue;
            default:
                throw new RuntimeException(UNKNOWN_ATTRIBUTE);
        }
    }
}
