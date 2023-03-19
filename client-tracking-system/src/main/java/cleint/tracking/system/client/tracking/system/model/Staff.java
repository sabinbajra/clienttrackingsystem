package cleint.tracking.system.client.tracking.system.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staff_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "position")
    private String position;
    @Column(name = "address")
    private String address;
    @Column(name = "contact")
    private String contact;

    public Staff() {
    }

    public Staff(int staff_id, String first_name, String last_name, String position, String address, String contact) {
        this.staff_id = staff_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.address = address;
        this.contact = contact;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return staff_id == staff.staff_id && Objects.equals(first_name, staff.first_name) && Objects.equals(last_name, staff.last_name) && Objects.equals(position, staff.position) && Objects.equals(address, staff.address) && Objects.equals(contact, staff.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staff_id, first_name, last_name, position, address, contact);
    }


}
