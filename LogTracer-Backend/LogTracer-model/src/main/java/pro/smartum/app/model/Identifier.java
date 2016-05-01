package pro.smartum.app.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class Identifier implements Serializable {

    private static final long serialVersionUID = 1L;

    public Identifier() {
    }

    public Identifier(Integer id) {
        this.id = id;
    }

    protected Integer id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Identifier identify = (Identifier) o;

        if (id != null ? !id.equals(identify.id) : identify.id != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}