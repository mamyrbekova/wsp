package containers;

import java.util.Objects;

public class Cabinet {
    private int cabinetNum;
    private int capacity;
    private CabinetType cabinetType;
    public Cabinet() {}
    public Cabinet(int cabinetNum, int capacity, CabinetType cabinetType) {
        this.cabinetNum = cabinetNum;
        this.capacity = capacity;
        this.cabinetType = cabinetType;
    }

    @Override
    public String toString() {
        return cabinetNum +
                "(" + capacity +
                ")" + cabinetType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cabinet cabinet = (Cabinet) o;
        return cabinetNum == cabinet.cabinetNum && capacity == cabinet.capacity && cabinetType == cabinet.cabinetType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cabinetNum, capacity, cabinetType);
    }

    public int getCabinetNum() {
        return cabinetNum;
    }

    public void setCabinetNum(int cabinetNum) {
        this.cabinetNum = cabinetNum;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public CabinetType getCabinetType() {
        return cabinetType;
    }

    public void setCabinetType(CabinetType cabinetType) {
        this.cabinetType = cabinetType;
    }
}
