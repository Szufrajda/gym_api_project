package pl.edu.pjwstk.gymapi.model;

import jakarta.persistence.*;
import pl.edu.pjwstk.gymapi.model.enums.PassType;

@Entity
public class Pass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PassType passtype;

    @OneToOne(fetch = FetchType.EAGER)
    private Client client;
    private double cena;

    public Pass(){}

    public Pass(Long id, PassType passtype, double cena, Client client) {
        this.id = id;
        this.passtype = passtype;
        this.cena = cena;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PassType getPasstype() {
        return passtype;
    }

    public double getCena() {
        return cena;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPasstype(PassType passtype) {
        this.passtype = passtype;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

}
