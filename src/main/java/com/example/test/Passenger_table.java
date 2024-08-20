package com.example.test;

public class Passenger_table {
    private int id_t;
    private String name_t;
    private String nationality_t;
    private String Gender_t;
    private String contact_t;
    private String Address_t;
    private int Promocpde_t;
    private int bank_T;
    private int Passport_t; // Changed to int

    // Constructor
    public Passenger_table(int id_t, String name_t, String nationality_t, String Gender_t, String contact_t,
                           String Address_t, int Promocpde_t, int bank_T, int Passport_t) {
        this.id_t = id_t;
        this.name_t = name_t;
        this.nationality_t = nationality_t;
        this.Gender_t = Gender_t;
        this.contact_t = contact_t;
        this.Address_t = Address_t;
        this.Promocpde_t = Promocpde_t;
        this.bank_T = bank_T;
        this.Passport_t = Passport_t;
    }

    // Getters and setters
    public int getId_t() { return id_t; }
    public void setId_t(int id_t) { this.id_t = id_t; }

    public String getName_t() { return name_t; }
    public void setName_t(String name_t) { this.name_t = name_t; }

    public String getNationality_t() { return nationality_t; }
    public void setNationality_t(String nationality_t) { this.nationality_t = nationality_t; }

    public String getGender_t() { return Gender_t; }
    public void setGender_t(String Gender_t) { this.Gender_t = Gender_t; }

    public String getContact_t() { return contact_t; }
    public void setContact_t(String contact_t) { this.contact_t = contact_t; }

    public String getAddress_t() { return Address_t; }
    public void setAddress_t(String Address_t) { this.Address_t = Address_t; }

    public int getPromocpde_t() { return Promocpde_t; }
    public void setPromocpde_t(int Promocpde_t) { this.Promocpde_t = Promocpde_t; }

    public int getBank_T() { return bank_T; }
    public void setBank_T(int bank_T) { this.bank_T = bank_T; }

    public int getPassport_t() { return Passport_t; } // Updated getter
    public void setPassport_t(int Passport_t) { this.Passport_t = Passport_t; } // Updated setter
}
