package com.example.texzad.zad1;

 class Vacancy {
     String vacansy;

     public Vacancy(String vacansy) {
         this.vacansy = vacansy;
     }

     public String getVacansy() {
         return vacansy;
     }

     public void setVacansy(String vacansy) {
         this.vacansy = vacansy;
     }

     @Override
     public String toString() {
         return vacansy;
     }
 }
