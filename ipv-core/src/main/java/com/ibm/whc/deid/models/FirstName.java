/*
 * (C) Copyright IBM Corp. 2016,2020
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.ibm.whc.deid.models;

import java.io.Serializable;

public class FirstName implements LocalizedEntity, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4173369720649054384L;
	private final String name;
  private final Gender gender;
  private final String nameCountryCode;

  /**
   * Gets name country code.
   *
   * @return the name country code
   */
  @Override
public String getNameCountryCode() {
    return nameCountryCode;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets gender.
   *
   * @return the gender
   */
  public Gender getGender() {
    return this.gender;
  }

  /**
   * Instantiates a new First name.
   *
   * @param name the name
   * @param nameCountryCode the name country code
   * @param gender the gender
   */
  public FirstName(String name, String nameCountryCode, Gender gender) {
    this.name = name;
    this.nameCountryCode = nameCountryCode;
    this.gender = gender;
  }
}
