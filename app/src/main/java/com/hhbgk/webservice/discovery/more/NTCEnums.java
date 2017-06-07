package com.hhbgk.webservice.discovery.more;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.0.8.0
//
// Created by Quasar Development at 04/04/2017
//
//---------------------------------------------------





public class NTCEnums
{

    public enum RotateMode
    {
        
        OFF(0),
        
        ON(1),
        
        AUTO(2);
        
        private int code;
        
        RotateMode(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static RotateMode fromString(String str)
        {
            if (str.equals("OFF"))
                return OFF;
            if (str.equals("ON"))
                return ON;
            if (str.equals("AUTO"))
                return AUTO;
		    return null;
        }
    }

    public enum SceneOrientationMode
    {
        
        MANUAL(0),
        
        AUTO(1);
        
        private int code;
        
        SceneOrientationMode(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static SceneOrientationMode fromString(String str)
        {
            if (str.equals("MANUAL"))
                return MANUAL;
            if (str.equals("AUTO"))
                return AUTO;
		    return null;
        }
    }

    public enum VideoEncoding
    {
        
        JPEG(0),
        
        MPEG4(1),
        
        H264(2);
        
        private int code;
        
        VideoEncoding(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static VideoEncoding fromString(String str)
        {
            if (str.equals("JPEG"))
                return JPEG;
            if (str.equals("MPEG4"))
                return MPEG4;
            if (str.equals("H264"))
                return H264;
		    return null;
        }
    }

    public enum Mpeg4Profile
    {
        
        SP(0),
        
        ASP(1);
        
        private int code;
        
        Mpeg4Profile(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static Mpeg4Profile fromString(String str)
        {
            if (str.equals("SP"))
                return SP;
            if (str.equals("ASP"))
                return ASP;
		    return null;
        }
    }

    public enum H264Profile
    {
        
        Baseline(0),
        
        Main(1),
        
        Extended(2),
        
        High(3);
        
        private int code;
        
        H264Profile(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static H264Profile fromString(String str)
        {
            if (str.equals("Baseline"))
                return Baseline;
            if (str.equals("Main"))
                return Main;
            if (str.equals("Extended"))
                return Extended;
            if (str.equals("High"))
                return High;
		    return null;
        }
    }

    public enum AudioEncoding
    {
        
        G711(0),
        
        G726(1),
        
        AAC(2);
        
        private int code;
        
        AudioEncoding(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static AudioEncoding fromString(String str)
        {
            if (str.equals("G711"))
                return G711;
            if (str.equals("G726"))
                return G726;
            if (str.equals("AAC"))
                return AAC;
		    return null;
        }
    }

    public enum Duplex
    {
        
        Full(0),
        
        Half(1);
        
        private int code;
        
        Duplex(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static Duplex fromString(String str)
        {
            if (str.equals("Full"))
                return Full;
            if (str.equals("Half"))
                return Half;
		    return null;
        }
    }

    public enum IPv6DHCPConfiguration
    {
        
        Auto(0),
        
        Stateful(1),
        
        Stateless(2),
        
        Off(3);
        
        private int code;
        
        IPv6DHCPConfiguration(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static IPv6DHCPConfiguration fromString(String str)
        {
            if (str.equals("Auto"))
                return Auto;
            if (str.equals("Stateful"))
                return Stateful;
            if (str.equals("Stateless"))
                return Stateless;
            if (str.equals("Off"))
                return Off;
		    return null;
        }
    }

    public enum IPType
    {
        
        IPv4(0),
        
        IPv6(1);
        
        private int code;
        
        IPType(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static IPType fromString(String str)
        {
            if (str.equals("IPv4"))
                return IPv4;
            if (str.equals("IPv6"))
                return IPv6;
		    return null;
        }
    }

    public enum Dot11StationMode
    {

        Adhoc(0),

        Infrastructure(1),

        Extended(2);

        private int code;

        Dot11StationMode(int code ){
            this.code = code;
        }

        public int getCode(){
		    return code;
	    }


        public static Dot11StationMode fromString(String str)
        {
            if (str.equals("Ad-hoc"))
                return Adhoc;
            if (str.equals("Infrastructure"))
                return Infrastructure;
            if (str.equals("Extended"))
                return Extended;
		    return null;
        }
    }

    public enum Dot11SecurityMode
    {
        
        None(0),
        
        WEP(1),
        
        PSK(2),
        
        Dot1X(3),
        
        Extended(4);
        
        private int code;
        
        Dot11SecurityMode(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static Dot11SecurityMode fromString(String str)
        {
            if (str.equals("None"))
                return None;
            if (str.equals("WEP"))
                return WEP;
            if (str.equals("PSK"))
                return PSK;
            if (str.equals("Dot1X"))
                return Dot1X;
            if (str.equals("Extended"))
                return Extended;
		    return null;
        }
    }

    public enum Dot11Cipher
    {
        
        CCMP(0),
        
        TKIP(1),
        
        Any(2),
        
        Extended(3);
        
        private int code;
        
        Dot11Cipher(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static Dot11Cipher fromString(String str)
        {
            if (str.equals("CCMP"))
                return CCMP;
            if (str.equals("TKIP"))
                return TKIP;
            if (str.equals("Any"))
                return Any;
            if (str.equals("Extended"))
                return Extended;
		    return null;
        }
    }

    public enum RelayIdleState
    {
        
        closed(0),
        
        open(1);
        
        private int code;
        
        RelayIdleState(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static RelayIdleState fromString(String str)
        {
            if (str.equals("closed"))
                return closed;
            if (str.equals("open"))
                return open;
		    return null;
        }
    }

    public enum RelayMode
    {
        
        Monostable(0),
        
        Bistable(1);
        
        private int code;
        
        RelayMode(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static RelayMode fromString(String str)
        {
            if (str.equals("Monostable"))
                return Monostable;
            if (str.equals("Bistable"))
                return Bistable;
		    return null;
        }
    }

    public enum DigitalIdleState
    {
        
        closed(0),
        
        open(1);
        
        private int code;
        
        DigitalIdleState(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static DigitalIdleState fromString(String str)
        {
            if (str.equals("closed"))
                return closed;
            if (str.equals("open"))
                return open;
		    return null;
        }
    }

    public enum EFlipMode
    {
        
        OFF(0),
        
        ON(1),
        
        Extended(2);
        
        private int code;
        
        EFlipMode(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static EFlipMode fromString(String str)
        {
            if (str.equals("OFF"))
                return OFF;
            if (str.equals("ON"))
                return ON;
            if (str.equals("Extended"))
                return Extended;
		    return null;
        }
    }

    public enum ReverseMode
    {
        
        OFF(0),
        
        ON(1),
        
        AUTO(2),
        
        Extended(3);
        
        private int code;
        
        ReverseMode(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static ReverseMode fromString(String str)
        {
            if (str.equals("OFF"))
                return OFF;
            if (str.equals("ON"))
                return ON;
            if (str.equals("AUTO"))
                return AUTO;
            if (str.equals("Extended"))
                return Extended;
		    return null;
        }
    }

    public enum PTZPresetTourOperation
    {
        
        Start(0),
        
        Stop(1),
        
        Pause(2),
        
        Extended(3);
        
        private int code;
        
        PTZPresetTourOperation(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static PTZPresetTourOperation fromString(String str)
        {
            if (str.equals("Start"))
                return Start;
            if (str.equals("Stop"))
                return Stop;
            if (str.equals("Pause"))
                return Pause;
            if (str.equals("Extended"))
                return Extended;
		    return null;
        }
    }

    public enum AutoFocusMode
    {
        
        AUTO(0),
        
        MANUAL(1);
        
        private int code;
        
        AutoFocusMode(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static AutoFocusMode fromString(String str)
        {
            if (str.equals("AUTO"))
                return AUTO;
            if (str.equals("MANUAL"))
                return MANUAL;
		    return null;
        }
    }

    public enum WideDynamicMode
    {
        
        OFF(0),
        
        ON(1);
        
        private int code;
        
        WideDynamicMode(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static WideDynamicMode fromString(String str)
        {
            if (str.equals("OFF"))
                return OFF;
            if (str.equals("ON"))
                return ON;
		    return null;
        }
    }

    public enum BacklightCompensationMode
    {
        
        OFF(0),
        
        ON(1);
        
        private int code;
        
        BacklightCompensationMode(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static BacklightCompensationMode fromString(String str)
        {
            if (str.equals("OFF"))
                return OFF;
            if (str.equals("ON"))
                return ON;
		    return null;
        }
    }

    public enum ExposurePriority
    {
        
        LowNoise(0),
        
        FrameRate(1);
        
        private int code;
        
        ExposurePriority(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static ExposurePriority fromString(String str)
        {
            if (str.equals("LowNoise"))
                return LowNoise;
            if (str.equals("FrameRate"))
                return FrameRate;
		    return null;
        }
    }

    public enum ExposureMode
    {
        
        AUTO(0),
        
        MANUAL(1);
        
        private int code;
        
        ExposureMode(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static ExposureMode fromString(String str)
        {
            if (str.equals("AUTO"))
                return AUTO;
            if (str.equals("MANUAL"))
                return MANUAL;
		    return null;
        }
    }

    public enum WhiteBalanceMode
    {
        
        AUTO(0),
        
        MANUAL(1);
        
        private int code;
        
        WhiteBalanceMode(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static WhiteBalanceMode fromString(String str)
        {
            if (str.equals("AUTO"))
                return AUTO;
            if (str.equals("MANUAL"))
                return MANUAL;
		    return null;
        }
    }

    public enum IrCutFilterMode
    {
        
        ON(0),
        
        OFF(1),
        
        AUTO(2);
        
        private int code;
        
        IrCutFilterMode(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static IrCutFilterMode fromString(String str)
        {
            if (str.equals("ON"))
                return ON;
            if (str.equals("OFF"))
                return OFF;
            if (str.equals("AUTO"))
                return AUTO;
		    return null;
        }
    }

    public enum ImageStabilizationMode
    {
        
        OFF(0),
        
        ON(1),
        
        AUTO(2),
        
        Extended(3);
        
        private int code;
        
        ImageStabilizationMode(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static ImageStabilizationMode fromString(String str)
        {
            if (str.equals("OFF"))
                return OFF;
            if (str.equals("ON"))
                return ON;
            if (str.equals("AUTO"))
                return AUTO;
            if (str.equals("Extended"))
                return Extended;
		    return null;
        }
    }

    public enum ModeOfOperation
    {
        
        Idle(0),
        
        Active(1),
        
        Unknown(2);
        
        private int code;
        
        ModeOfOperation(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static ModeOfOperation fromString(String str)
        {
            if (str.equals("Idle"))
                return Idle;
            if (str.equals("Active"))
                return Active;
            if (str.equals("Unknown"))
                return Unknown;
		    return null;
        }
    }

    public enum OSDType
    {
        
        Text(0),
        
        Image(1),
        
        Extended(2);
        
        private int code;
        
        OSDType(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static OSDType fromString(String str)
        {
            if (str.equals("Text"))
                return Text;
            if (str.equals("Image"))
                return Image;
            if (str.equals("Extended"))
                return Extended;
		    return null;
        }
    }

}