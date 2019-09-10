package spring.model;

import javax.persistence.*;


@Entity
@Table(name = "orders", schema = "public", catalog = "penek")
public class OrdersEntity {

    private Integer id;

    private String status;
    private Long statusReserved;
    private Long statusArrived;
    private Long statusTesting;
    private Long statusFinished;
    private Long statusDenied;

    private AutoEntity auto;
    private CustomerEntity customer;

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
    @Column(name = "status", nullable = true, length = 16)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "status_reserved", nullable = true)
    public Long getStatusReserved() {
        return statusReserved;
    }

    public void setStatusReserved(Long statusReserved) {
        this.statusReserved = statusReserved;
    }

    @Basic
    @Column(name = "status_arrived", nullable = true)
    public Long getStatusArrived() {
        return statusArrived;
    }

    public void setStatusArrived(Long statusArrived) {
        this.statusArrived = statusArrived;
    }

    @Basic
    @Column(name = "status_testing", nullable = true)
    public Long getStatusTesting() {
        return statusTesting;
    }

    public void setStatusTesting(Long statusTesting) {
        this.statusTesting = statusTesting;
    }

    @Basic
    @Column(name = "status_finished", nullable = true)
    public Long getStatusFinished() {
        return statusFinished;
    }

    public void setStatusFinished(Long statusFinished) {
        this.statusFinished = statusFinished;
    }

    @Basic
    @Column(name = "status_denied", nullable = true)
    public Long getStatusDenied() {
        return statusDenied;
    }

    public void setStatusDenied(Long statusDenied) {
        this.statusDenied = statusDenied;
    }

    @ManyToOne
    @JoinColumn(name = "auto_id", referencedColumnName = "id")
    public AutoEntity getAuto() {
        return auto;
    }

    public void setAuto(AutoEntity auto) {
        this.auto = auto;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}
