package study.yan.thinking.in.spring.ioc.overview.domain;

import study.yan.thinking.in.spring.ioc.overview.annotation.Super;

@Super
public class SupperUser extends User {
    private String power;

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "SupperUser{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                "power='" + power + '\'' +
                '}';
    }
}
