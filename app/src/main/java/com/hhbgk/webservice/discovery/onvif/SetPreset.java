package com.hhbgk.webservice.discovery.onvif;

import org.ksoap2.serialization.SoapObject;

public class SetPreset extends SoapObject {
	public static final String METHOD_NAME = SetPreset.class.getSimpleName();

	public SetPreset() {
		super(PTZService.NAMESPACE, METHOD_NAME);
	}

	public void setProfileToken(String profileToken) {
		this.addProperty(PTZService.NAMESPACE, "ProfileToken", profileToken);
	}

	public void setPresetName(String presetName) {
		if (presetName != null && !presetName.equals(""))
			this.addProperty(PTZService.NAMESPACE, "PresetName", presetName);
	}

	public void setPresetToken(String presetToken) {
		if (presetToken != null && !presetToken.equals(""))
			this.addProperty(PTZService.NAMESPACE, "PresetToken", presetToken);
	}
}
