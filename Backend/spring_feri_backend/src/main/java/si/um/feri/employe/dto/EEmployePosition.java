package si.um.feri.employe.dto;

public enum EEmployePosition {

    BEGIN_DEVELOPER, MID_DEVELOPER, SENIOR_DEVELOPER, DIRECTOR, UNDEFINED;

    public static double getBasicSalary() {
        return 400.0;
    }

    public double getMaxSalaryFactor(){
        if(this == DIRECTOR) {return 10.0;}
        if(this == BEGIN_DEVELOPER) {return 6.0;}
        if(this == MID_DEVELOPER) {return 8.0;}
        if(this == SENIOR_DEVELOPER) {return 9.0;}
        return 0.0;
    }

    public double getMinSalaryFactor(){
        if(this == DIRECTOR) {return 8.0;}
        if(this == BEGIN_DEVELOPER) {return 4.0;}
        if(this == MID_DEVELOPER) {return 5.0;}
        if(this == SENIOR_DEVELOPER) {return 6.0;}
        return 0.0;
    }

}
