package com.hhbgk.webservice.discovery.more;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.0.8.0
//
// Created by Quasar Development at 04/04/2017
//
//---------------------------------------------------


import java.util.Hashtable;
import org.ksoap2.serialization.*;

public class NTCImagingSettings20 extends AttributeContainer implements KvmSerializable
{

    
    public NTCBacklightCompensation20 BacklightCompensation;
    
    public Float Brightness;
    
    public Float ColorSaturation;
    
    public Float Contrast;
    
    public NTCExposure20 Exposure;
    
    public NTCFocusConfiguration20 Focus;
    
    public NTCEnums.IrCutFilterMode IrCutFilter;
    
    public Float Sharpness;
    
    public NTCWideDynamicRange20 WideDynamicRange;
    
    public NTCWhiteBalance20 WhiteBalance;
    
    public NTCImagingSettingsExtension20 Extension;

    public NTCImagingSettings20 ()
    {
    }

    public NTCImagingSettings20 (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
    {
	    
	    if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;


        if(inObj instanceof SoapObject)
        {
            SoapObject soapObject=(SoapObject)inObj;
            int size = soapObject.getPropertyCount();
            for (int i0=0;i0< size;i0++)
            {
                //if you have compilation error here, please use a ksoap2.jar and ExKsoap2.jar from libs folder (in the generated zip file)
                PropertyInfo info=soapObject.getPropertyInfo(i0);
                Object obj = info.getValue();
                if (info.name.equals("BacklightCompensation"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.BacklightCompensation = (NTCBacklightCompensation20)__envelope.get(j,NTCBacklightCompensation20.class,false);
                    }
                    continue;
                }
                if (info.name.equals("Brightness"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.Brightness = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.Brightness = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("ColorSaturation"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.ColorSaturation = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.ColorSaturation = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("Contrast"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.Contrast = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.Contrast = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("Exposure"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Exposure = (NTCExposure20)__envelope.get(j,NTCExposure20.class,false);
                    }
                    continue;
                }
                if (info.name.equals("Focus"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Focus = (NTCFocusConfiguration20)__envelope.get(j,NTCFocusConfiguration20.class,false);
                    }
                    continue;
                }
                if (info.name.equals("IrCutFilter"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.IrCutFilter = NTCEnums.IrCutFilterMode.fromString(j.toString());
                            }
                        }
                        else if (obj instanceof NTCEnums.IrCutFilterMode){
                            this.IrCutFilter = (NTCEnums.IrCutFilterMode)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("Sharpness"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.Sharpness = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.Sharpness = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("WideDynamicRange"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.WideDynamicRange = (NTCWideDynamicRange20)__envelope.get(j,NTCWideDynamicRange20.class,false);
                    }
                    continue;
                }
                if (info.name.equals("WhiteBalance"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.WhiteBalance = (NTCWhiteBalance20)__envelope.get(j,NTCWhiteBalance20.class,false);
                    }
                    continue;
                }
                if (info.name.equals("Extension"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Extension = (NTCImagingSettingsExtension20)__envelope.get(j,NTCImagingSettingsExtension20.class,false);
                    }
                    continue;
                }

            }

        }



    }

    @Override
    public Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return this.BacklightCompensation!=null?this.BacklightCompensation:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.Brightness!=null?this.Brightness:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2)
        {
            return this.ColorSaturation!=null?this.ColorSaturation:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==3)
        {
            return this.Contrast!=null?this.Contrast:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==4)
        {
            return this.Exposure!=null?this.Exposure:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==5)
        {
            return this.Focus!=null?this.Focus:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==6)
        {
            return this.IrCutFilter!=null?this.IrCutFilter.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==7)
        {
            return this.Sharpness!=null?this.Sharpness:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==8)
        {
            return this.WideDynamicRange!=null?this.WideDynamicRange:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==9)
        {
            return this.WhiteBalance!=null?this.WhiteBalance:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==10)
        {
            return this.Extension!=null?this.Extension:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 11;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = NTCBacklightCompensation20.class;
            info.name = "BacklightCompensation";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==1)
        {
            info.type = Float.class;
            info.name = "Brightness";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==2)
        {
            info.type = Float.class;
            info.name = "ColorSaturation";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==3)
        {
            info.type = Float.class;
            info.name = "Contrast";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==4)
        {
            info.type = NTCExposure20.class;
            info.name = "Exposure";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==5)
        {
            info.type = NTCFocusConfiguration20.class;
            info.name = "Focus";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==6)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "IrCutFilter";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==7)
        {
            info.type = Float.class;
            info.name = "Sharpness";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==8)
        {
            info.type = NTCWideDynamicRange20.class;
            info.name = "WideDynamicRange";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==9)
        {
            info.type = NTCWhiteBalance20.class;
            info.name = "WhiteBalance";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==10)
        {
            info.type = NTCImagingSettingsExtension20.class;
            info.name = "Extension";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }

    
}
