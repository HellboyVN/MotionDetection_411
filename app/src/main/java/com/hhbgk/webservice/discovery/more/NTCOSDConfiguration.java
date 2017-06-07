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

public class NTCOSDConfiguration extends NTCDeviceEntity implements KvmSerializable
{

    
    public NTCOSDReference VideoSourceConfigurationToken;
    
    public NTCEnums.OSDType Type=NTCEnums.OSDType.Text;
    
    public NTCOSDPosConfiguration Position;
    
    public NTCOSDTextConfiguration TextString;
    
    public NTCOSDImgConfiguration Image;
    
    public NTCOSDConfigurationExtension Extension;

    public NTCOSDConfiguration ()
    {
    }

    public NTCOSDConfiguration (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("VideoSourceConfigurationToken"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.VideoSourceConfigurationToken = (NTCOSDReference)__envelope.get(j,NTCOSDReference.class,false);
                    }
                    continue;
                }
                if (info.name.equals("Type"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.Type = NTCEnums.OSDType.fromString(j.toString());
                            }
                        }
                        else if (obj instanceof NTCEnums.OSDType){
                            this.Type = (NTCEnums.OSDType)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("Position"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Position = (NTCOSDPosConfiguration)__envelope.get(j,NTCOSDPosConfiguration.class,false);
                    }
                    continue;
                }
                if (info.name.equals("TextString"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.TextString = (NTCOSDTextConfiguration)__envelope.get(j,NTCOSDTextConfiguration.class,false);
                    }
                    continue;
                }
                if (info.name.equals("Image"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Image = (NTCOSDImgConfiguration)__envelope.get(j,NTCOSDImgConfiguration.class,false);
                    }
                    continue;
                }
                if (info.name.equals("Extension"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Extension = (NTCOSDConfigurationExtension)__envelope.get(j,NTCOSDConfigurationExtension.class,false);
                    }
                    continue;
                }

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
            return this.VideoSourceConfigurationToken!=null?this.VideoSourceConfigurationToken.getSimpleValue():null;
        }
        if(propertyIndex==count+1)
        {
            return this.Type!=null?this.Type.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+2)
        {
            return Position;
        }
        if(propertyIndex==count+3)
        {
            return this.TextString!=null?this.TextString:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+4)
        {
            return this.Image!=null?this.Image:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+5)
        {
            return this.Extension!=null?this.Extension:SoapPrimitive.NullSkip;
        }
        return super.getProperty(propertyIndex);
    }


    @Override
    public int getPropertyCount() {
        return super.getPropertyCount()+6;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        int count = super.getPropertyCount();
        if(propertyIndex==count+0)
        {
            info.type = SoapPrimitive.class;
            info.name = "VideoSourceConfigurationToken";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Type";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+2)
        {
            info.type = NTCOSDPosConfiguration.class;
            info.name = "Position";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+3)
        {
            info.type = NTCOSDTextConfiguration.class;
            info.name = "TextString";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+4)
        {
            info.type = NTCOSDImgConfiguration.class;
            info.name = "Image";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+5)
        {
            info.type = NTCOSDConfigurationExtension.class;
            info.name = "Extension";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        super.getPropertyInfo(propertyIndex,arg1,info);
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }

    
}
