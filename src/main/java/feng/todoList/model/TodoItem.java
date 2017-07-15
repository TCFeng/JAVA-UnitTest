package feng.todoList.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * Created by 10503313 on 2017/7/3.
 */

@Entity
@Table(name = "todos")
public class TodoItem implements Serializable {

    private static final long serialVersionUID = -3465813074586302847L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column
    private String item;

    @Column
    private String owner;

    @Column
    private String dueDate;

    @Column
    private Boolean done;

    public int getId() {return Id;}

    public void setId(int id) {
        Id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }



}
/*

    CREATE TABLE public.todos
        (
        id SERIAL,
        item character varying(255) NOT NULL,
        owner character varying(50) NOT NULL,
        duedate character varying(14) NOT NULL,
        done boolean NOT NULL DEFAULT false,
        CONSTRAINT todos_pkey PRIMARY KEY (id)
        )

*/
