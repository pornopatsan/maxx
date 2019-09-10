package spring.model;

import javax.persistence.*;


@Entity
@Table(name = "automobiles", schema = "public", catalog = "penek")
public class AutoEntity {

    private Integer id;
    private String serialNumber;

    private String supplier;
    private String mark;

    private Double enginePower;
    private Double engineCapacity;
    private Double fuelCapacity;
    private Double fuelConsumption;
    private Boolean autoGearBox;

    private Double mass;
    private String color;
    private Integer seats;
    private Integer cost;

    private String lastService;
    private Integer mileageKm;

    private Boolean inStock;
    private Boolean isSold;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "serial_number", nullable = true, length = 16)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Basic
    @Column(name = "supplier", nullable = true, length = 16)
    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Basic
    @Column(name = "mark", nullable = true, length = 32)
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "engine_power", nullable = true, precision = 1)
    public Double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Double enginePower) {
        this.enginePower = enginePower;
    }

    @Basic
    @Column(name = "engine_capacityr", nullable = true, precision = 1)
    public Double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Basic
    @Column(name = "fuel_power", nullable = true, precision = 1)
    public Double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    @Basic
    @Column(name = "fuel_consumption", nullable = true, precision = 1)
    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Basic
    @Column(name = "gearbox", nullable = true)
    public Boolean getAutoGearBox() {
        return autoGearBox;
    }

    public void setAutoGearBox(Boolean autoGearBox) {
        this.autoGearBox = autoGearBox;
    }

    @Basic
    @Column(name = "mass", nullable = true, precision = 1)
    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    @Basic
    @Column(name = "color", nullable = true)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "seats", nullable = true)
    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @Basic
    @Column(name = "cost", nullable = true, precision = 1)
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "last_service", nullable = true)
    public String getLastService() {
        return lastService;
    }

    public void setLastService(String lastService) {
        this.lastService = lastService;
    }

    @Basic
    @Column(name = "mileage", nullable = true)
    public Integer getMileageKm() {
        return mileageKm;
    }

    public void setMileageKm(Integer mileageKm) {
        this.mileageKm = mileageKm;
    }

    @Basic
    @Column(name = "in_stock", nullable = true)
    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    @Basic
    @Column(name = "is_sold", nullable = true)
    public Boolean getIsSold() {
        return isSold;
    }

    public void setIsSold(Boolean isSold) {
        this.isSold = isSold;
    }
}
