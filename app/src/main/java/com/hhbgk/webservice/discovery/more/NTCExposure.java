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

public class NTCExposure extends AttributeContainer implements KvmSerializable
{

    
    public NTCEnums.ExposureMode Mode=NTCEnums.ExposureMode.AUTO;
    
    public NTCEnums.ExposurePriority Priority=NTCEnums.ExposurePriority.LowNoise;
    
    public NTCRectangle Window;
    
    public Float MinExposureTime=0f;
    
    public Float MaxExposureTime=0f;
    
    public Float MinGain=0f;
    
    public Float MaxGain=0f;
    
    public Float MinIris=0f;
    
    public Float MaxIris=0f;
    
    public Float ExposureTime=0f;
    
    public Float Gain=0f;
    
    public Float Iris=0f;

    public NTCExposure ()
    {
    }

    public NTCExposure (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("Mode"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.Mode = NTCEnums.ExposureMode.fromString(j.toString());
                            }
                        }
                        else if (obj instanceof NTCEnums.ExposureMode){
                            this.Mode = (NTCEnums.ExposureMode)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("Priority"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.Priority = NTCEnums.ExposurePriority.fromString(j.toString());
                            }
                        }
                        else if (obj instanceof NTCEnums.ExposurePriority){
                            this.Priority = (NTCEnums.ExposurePriority)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("Window"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Window = (NTCRectangle)__envelope.get(j,NTCRectangle.class,false);
                    }
                    continue;
                }
                if (info.name.equals("MinExposureTime"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.MinExposureTime = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.MinExposureTime = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("MaxExposureTime"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.MaxExposureTime = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.MaxExposureTime = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("MinGain"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.MinGain = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.MinGain = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("MaxGain"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.MaxGain = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.MaxGain = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("MinIris"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.MinIris = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.MinIris = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("MaxIris"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.MaxIris = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.MaxIris = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("ExposureTime"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.ExposureTime = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.ExposureTime = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("Gain"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.Gain = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.Gain = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("Iris"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.Iris = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.Iris = (Float)obj;
                        }
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
            return this.Mode!=null?this.Mode.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.Priority!=null?this.Priority.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2)
        {
            return Window;
        }
        if(propertyIndex==3)
        {
            return MinExposureTime;
        }
        if(propertyIndex==4)
        {
            return MaxExposureTime;
        }
        if(propertyIndex==5)
        {
            return MinGain;
        }
        if(propertyIndex==6)
        {
            return MaxGain;
        }
        if(propertyIndex==7)
        {
            return MinIris;
        }
        if(propertyIndex==8)
        {
            return MaxIris;
        }
        if(propertyIndex==9)
        {
            return ExposureTime;
        }
        if(propertyIndex==10)
        {
            return Gain;
        }
        if(propertyIndex==11)
        {
            return Iris;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 12;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Mode";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Priority";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==2)
        {
            info.type = NTCRectangle.class;
            info.name = "Window";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==3)
        {
            info.type = Float.class;
            info.name = "MinExposureTime";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==4)
        {
            info.type = Float.class;
            info.name = "MaxExposureTime";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==5)
        {
            info.type = Float.class;
            info.name = "MinGain";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==6)
        {
            info.type = Float.class;
            info.name = "MaxGain";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==7)
        {
            info.type = Float.class;
            info.name = "MinIris";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==8)
        {
            info.type = Float.class;
            info.name = "MaxIris";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==9)
        {
            info.type = Float.class;
            info.name = "ExposureTime";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==10)
        {
            info.type = Float.class;
            info.name = "Gain";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==11)
        {
            info.type = Float.class;
            info.name = "Iris";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }

    
}

