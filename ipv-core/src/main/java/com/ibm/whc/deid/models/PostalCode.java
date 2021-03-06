/*
 * (C) Copyright IBM Corp. 2016,2020
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.ibm.whc.deid.models;

import java.io.Serializable;

public class PostalCode implements Location,Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 5510030912035883146L;
private String code;
  private LatitudeLongitude latitudeLongitude;

  /**
   * Instantiates a new Postal code.
   *
   * @param code the code
   * @param latitude the latitude
   * @param longitude the longitude
   */
  public PostalCode(String code, Double latitude, Double longitude) {
    this.code = code;
    this.latitudeLongitude =
        new LatitudeLongitude(latitude, longitude, LatitudeLongitudeFormat.DECIMAL);
  }

  @Override
  public LatitudeLongitude getLocation() {
    return this.latitudeLongitude;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return this.code;
  }
}
