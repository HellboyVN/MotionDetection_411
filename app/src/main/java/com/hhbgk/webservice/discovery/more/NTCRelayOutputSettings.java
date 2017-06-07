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

public class NTCRelayOutputSettings extends AttributeContainer implements KvmSerializable
{

    
    public NTCEnums.RelayMode Mode=NTCEnums.RelayMode.Monostable;
    
    public String DelayTime;
    
    public NTCEnums.RelayIdleState IdleState=NTCEnums.RelayIdleState.closed;

    public NTCRelayOutputSettings ()
    {
    }

    public NTCRelayOutputSettings (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
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
                                this.Mode = NTCEnums.RelayMode.fromString(j.toString());
                            }
                        }
                        else if (obj instanceof NTCEnums.RelayMode){
                            this.Mode = (NTCEnums.RelayMode)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("DelayTime"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.DelayTime = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.DelayTime = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("IdleState"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.IdleState = NTCEnums.RelayIdleState.fromString(j.toString());
                            }
                        }
                        else if (obj instanceof NTCEnums.RelayIdleState){
                            this.IdleState = (NTCEnums.RelayIdleState)obj;
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
            return DelayTime;
        }
        if(propertyIndex==2)
        {
            return this.IdleState!=null?this.IdleState.toString():SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 3;
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
            info.name = "DelayTime";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "IdleState";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }

    
}
