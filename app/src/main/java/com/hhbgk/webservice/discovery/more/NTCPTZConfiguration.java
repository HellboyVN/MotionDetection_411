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

public class NTCPTZConfiguration extends NTCConfigurationEntity implements KvmSerializable
{

    
    public String NodeToken;
    
    public String DefaultAbsolutePantTiltPositionSpace;
    
    public String DefaultAbsoluteZoomPositionSpace;
    
    public String DefaultRelativePanTiltTranslationSpace;
    
    public String DefaultRelativeZoomTranslationSpace;
    
    public String DefaultContinuousPanTiltVelocitySpace;
    
    public String DefaultContinuousZoomVelocitySpace;
    
    public NTCPTZSpeed DefaultPTZSpeed;
    
    public String DefaultPTZTimeout;
    
    public NTCPanTiltLimits PanTiltLimits;
    
    public NTCZoomLimits ZoomLimits;
    
    public NTCPTZConfigurationExtension Extension;
    
    public Integer MoveRamp=0;
    
    public Integer PresetRamp=0;
    
    public Integer PresetTourRamp=0;

    public NTCPTZConfiguration ()
    {
    }

    public NTCPTZConfiguration (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
    {
	    super(paramObj, __envelope);
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
                if (info.name.equals("NodeToken"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.NodeToken = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.NodeToken = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("DefaultAbsolutePantTiltPositionSpace"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.DefaultAbsolutePantTiltPositionSpace = j.toString();
                            }
                        }
                        else{
                            this.DefaultAbsolutePantTiltPositionSpace = obj.toString();
                        }
                    }
                    continue;
                }
                if (info.name.equals("DefaultAbsoluteZoomPositionSpace"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.DefaultAbsoluteZoomPositionSpace = j.toString();
                            }
                        }
                        else{
                            this.DefaultAbsoluteZoomPositionSpace = obj.toString();
                        }
                    }
                    continue;
                }
                if (info.name.equals("DefaultRelativePanTiltTranslationSpace"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.DefaultRelativePanTiltTranslationSpace = j.toString();
                            }
                        }
                        else{
                            this.DefaultRelativePanTiltTranslationSpace = obj.toString();
                        }
                    }
                    continue;
                }
                if (info.name.equals("DefaultRelativeZoomTranslationSpace"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.DefaultRelativeZoomTranslationSpace = j.toString();
                            }
                        }
                        else{
                            this.DefaultRelativeZoomTranslationSpace = obj.toString();
                        }
                    }
                    continue;
                }
                if (info.name.equals("DefaultContinuousPanTiltVelocitySpace"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.DefaultContinuousPanTiltVelocitySpace = j.toString();
                            }
                        }
                        else{
                            this.DefaultContinuousPanTiltVelocitySpace = obj.toString();
                        }
                    }
                    continue;
                }
                if (info.name.equals("DefaultContinuousZoomVelocitySpace"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.DefaultContinuousZoomVelocitySpace = j.toString();
                            }
                        }
                        else{
                            this.DefaultContinuousZoomVelocitySpace = obj.toString();
                        }
                    }
                    continue;
                }
                if (info.name.equals("DefaultPTZSpeed"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.DefaultPTZSpeed = (NTCPTZSpeed)__envelope.get(j,NTCPTZSpeed.class,false);
                    }
                    continue;
                }
                if (info.name.equals("DefaultPTZTimeout"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.DefaultPTZTimeout = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.DefaultPTZTimeout = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("PanTiltLimits"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.PanTiltLimits = (NTCPanTiltLimits)__envelope.get(j,NTCPanTiltLimits.class,false);
                    }
                    continue;
                }
                if (info.name.equals("ZoomLimits"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.ZoomLimits = (NTCZoomLimits)__envelope.get(j,NTCZoomLimits.class,false);
                    }
                    continue;
                }
                if (info.name.equals("Extension"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Extension = (NTCPTZConfigurationExtension)__envelope.get(j,NTCPTZConfigurationExtension.class,false);
                    }
                    continue;
                }

            }

        }



        if (inObj.hasAttribute("MoveRamp"))
        {	
            Object j = inObj.getAttribute("MoveRamp");
            if (j != null)
            {
                MoveRamp = Integer.parseInt(j.toString());
	            
            }
        }

        if (inObj.hasAttribute("PresetRamp"))
        {	
            Object j = inObj.getAttribute("PresetRamp");
            if (j != null)
            {
                PresetRamp = Integer.parseInt(j.toString());
	            
            }
        }

        if (inObj.hasAttribute("PresetTourRamp"))
        {	
            Object j = inObj.getAttribute("PresetTourRamp");
            if (j != null)
            {
                PresetTourRamp = Integer.parseInt(j.toString());
	            
            }
        }

    }

    @Override
    public Object getProperty(int propertyIndex) {
        int count = super.getPropertyCount();
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==count+0)
        {
            return NodeToken;
        }
        if(propertyIndex==count+1)
        {
            return this.DefaultAbsolutePantTiltPositionSpace!=null?this.DefaultAbsolutePantTiltPositionSpace:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+2)
        {
            return this.DefaultAbsoluteZoomPositionSpace!=null?this.DefaultAbsoluteZoomPositionSpace:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+3)
        {
            return this.DefaultRelativePanTiltTranslationSpace!=null?this.DefaultRelativePanTiltTranslationSpace:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+4)
        {
            return this.DefaultRelativeZoomTranslationSpace!=null?this.DefaultRelativeZoomTranslationSpace:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+5)
        {
            return this.DefaultContinuousPanTiltVelocitySpace!=null?this.DefaultContinuousPanTiltVelocitySpace:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+6)
        {
            return this.DefaultContinuousZoomVelocitySpace!=null?this.DefaultContinuousZoomVelocitySpace:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+7)
        {
            return this.DefaultPTZSpeed!=null?this.DefaultPTZSpeed:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+8)
        {
            return this.DefaultPTZTimeout!=null?this.DefaultPTZTimeout:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+9)
        {
            return this.PanTiltLimits!=null?this.PanTiltLimits:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+10)
        {
            return this.ZoomLimits!=null?this.ZoomLimits:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+11)
        {
            return this.Extension!=null?this.Extension:SoapPrimitive.NullSkip;
        }
        return super.getProperty(propertyIndex);
    }


    @Override
    public int getPropertyCount() {
        return super.getPropertyCount()+12;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        int count = super.getPropertyCount();
        if(propertyIndex==count+0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "NodeToken";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "DefaultAbsolutePantTiltPositionSpace";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "DefaultAbsoluteZoomPositionSpace";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+3)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "DefaultRelativePanTiltTranslationSpace";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+4)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "DefaultRelativeZoomTranslationSpace";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+5)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "DefaultContinuousPanTiltVelocitySpace";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+6)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "DefaultContinuousZoomVelocitySpace";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+7)
        {
            info.type = NTCPTZSpeed.class;
            info.name = "DefaultPTZSpeed";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+8)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "DefaultPTZTimeout";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+9)
        {
            info.type = NTCPanTiltLimits.class;
            info.name = "PanTiltLimits";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+10)
        {
            info.type = NTCZoomLimits.class;
            info.name = "ZoomLimits";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+11)
        {
            info.type = NTCPTZConfigurationExtension.class;
            info.name = "Extension";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        super.getPropertyInfo(propertyIndex,arg1,info);
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }



    @Override
    public int getAttributeCount() {
        return super.getAttributeCount() + 3;
    }
    
    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        int count=super.getAttributeCount();
        if(index==count+0)
        {
            info.name = "MoveRamp";
            info.namespace= "";
            if(this.MoveRamp!=null)
            {
                info.setValue(this.MoveRamp);
            }
            
        }
        if(index==count+1)
        {
            info.name = "PresetRamp";
            info.namespace= "";
            if(this.PresetRamp!=null)
            {
                info.setValue(this.PresetRamp);
            }
            
        }
        if(index==count+2)
        {
            info.name = "PresetTourRamp";
            info.namespace= "";
            if(this.PresetTourRamp!=null)
            {
                info.setValue(this.PresetTourRamp);
            }
            
        }
        if(index < count)
        {
            super.getAttributeInfo(index, info);
        }
    }

    @Override
    public void getAttribute(int i, AttributeInfo attributeInfo) {

    }

    @Override
    public void setAttribute(AttributeInfo attributeInfo) {

    }    
}
