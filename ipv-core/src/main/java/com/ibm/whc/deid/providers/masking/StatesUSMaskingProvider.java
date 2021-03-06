/*
 * (C) Copyright IBM Corp. 2016,2020
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.ibm.whc.deid.providers.masking;

import com.ibm.whc.deid.models.State;
import com.ibm.whc.deid.shared.localization.Resource;
import com.ibm.whc.deid.shared.pojo.config.masking.StatesUSMaskingProviderConfig;
import com.ibm.whc.deid.util.ManagerFactory;
import com.ibm.whc.deid.util.StatesUSManager;

public class StatesUSMaskingProvider extends AbstractMaskingProvider {
  /** */
  private static final long serialVersionUID = -5570733724994623092L;

  protected StatesUSManager statesUSManager =
      (StatesUSManager) ManagerFactory
      .getInstance().getManager(null, Resource.STATES_US, null);

  protected volatile boolean initialized = false;

  /**
   * Instantiates a new StatusUS status masking provider.
   *
   * @param random the random
   * @param configuration the configuration
   */
  public StatesUSMaskingProvider(StatesUSMaskingProviderConfig configuration, String tenantId) {
  }

  protected void initialize() {
    if (!initialized) {
      statesUSManager =
          (StatesUSManager) ManagerFactory.getInstance().getManager(null, Resource.STATES_US, null);

      initialized = true;
    }
  }

  @Override
  public String mask(String identifier) {
    initialize();
    State state = statesUSManager.getKey(identifier);

    if (state == null) {
      return statesUSManager.getRandomKey();
    }

    State randomState = statesUSManager.getRandomValue(state.getNameCountryCode());

    return randomState.toString(state.getNameFormat());
  }

}
