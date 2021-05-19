package com.export.domain;

import java.io.Serializable;

public class Dept implements Serializable {
 
   private String deptId;
   private String deptName;
   private Dept parent;
   private String state;
   private String companyId;
   private String companyName;

   public String getDeptId() {
      return deptId;
   }

   public void setDeptId(String deptId) {
      this.deptId = deptId;
   }

   public String getDeptName() {
      return deptName;
   }

   public void setDeptName(String deptName) {
      this.deptName = deptName;
   }

   public Dept getParent() {
      return parent;
   }

   public void setParent(Dept parent) {
      this.parent = parent;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public String getCompanyId() {
      return companyId;
   }

   public void setCompanyId(String companyId) {
      this.companyId = companyId;
   }

   public String getCompanyName() {
      return companyName;
   }

   public void setCompanyName(String companyName) {
      this.companyName = companyName;
   }
}
