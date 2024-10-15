package com.ProjectoJavaSpring.jpa.JAVASPRING.model;

@Entity
public class Compra {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    private Motos moto;

    @Temporal(TemporalType.DATE)
    private Date fecha;
    //setters getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {    
        this.id = id;
    }  

    

}
