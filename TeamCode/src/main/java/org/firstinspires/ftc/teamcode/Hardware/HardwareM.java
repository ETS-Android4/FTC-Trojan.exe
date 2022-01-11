package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareM extends LinearOpMode
{
    public DcMotor roataStanga  = null;     //Motoare fata
    public DcMotor roataDreapta = null;

    public DcMotor brat_S       = null;     //Motoare brat
    public DcMotor brat_D       = null;
    public DcMotor brat_A       = null;

    public DcMotor peria        = null;     //Altele
    public DcMotor carusel      = null;

    /**
     * <h2>Numarul de rotatii pentru a te deplasa un inch: </h2>
     * <b>Circumferinta</b> este distanta pe care o parcurge roata cand completeaza o rotatie. Impartim distanta pe
     * care dorim s-o parcurgem noi la circumferinta si obtinem numarul de rotatii necesare, <b>rotatieInch</b>.<br></br>
     * Acum, in cazul nostru, <b>rotatieInch</b> trebuie doar multiplicata cu distanta dorita, rezultand nr de rotatii.
     */
    public static final double circumferintaRoata    = 11.1257;
    public static final double circumferintaScripete = 9.42;

    public static final double rotatieInch  = 1/ circumferintaRoata;    //TODO: telemetry 1 foot = 12 inches
    public static final double rotatieInchS = 1/circumferintaScripete;

    /**
     * <b>TICK_COUNTS</b> reprezinta nr de tickuri de encoder pana ca axul motorului face o rotatie si implicit nr de
     * tickuri pana la completarea unei rotatii a rotilor.<br>
     * Asadar, variabilele <b>TICKS_PER_INCH</b> ne vor arata nr de tickuri pentru a parcurge distanta de 1 inch. Ne
     * mai ramane doar sa le multiplicam cu distanta dorita.
     */
    public static final int NEVEREST40_TICK_COUNTS  = 1120;
    public static final int TETRIX_TICK_COUNTS      = 1440;
    public static final int REV_COREHEX_TICK_COUNTS = 288;

    public static final int NEVEREST40_TICKS_PER_INCH  = (int)(rotatieInch*NEVEREST40_TICK_COUNTS);
    public static final int TETRIX_TICKS_PER_INCH      = (int)(rotatieInch*TETRIX_TICK_COUNTS);
    public static final int REV_COREHEX_TICKS_PER_INCH = (int)(rotatieInch*REV_COREHEX_TICK_COUNTS);

    public static final int SCRIPETE_ROTATION = (int)(rotatieInchS*TETRIX_TICK_COUNTS);

//    private ElapsedTime perioada = new ElapsedTime();     //TODO: fa autonoma sa se opreasca dupa perioada de timp permisa

    public void init (HardwareMap hardwaremap, Boolean useEncoders){
        roataStanga  = hardwaremap.get(DcMotor.class, "motorStanga");       //Motoare
        roataDreapta = hardwaremap.get(DcMotor.class, "motorDreapta");
        brat_S       = hardwaremap.get(DcMotor.class, "motorS");
        brat_D       = hardwaremap.get(DcMotor.class, "motorD");
        brat_A       = hardwaremap.get(DcMotor.class, "motor3");
        peria        = hardwaremap.get(DcMotor.class, "motorPeria");
        carusel      = hardwaremap.get(DcMotor.class, "motorCarusel");

            //Servouri

        set0Behaviour(roataStanga, roataDreapta, brat_S, brat_D, brat_A, peria, carusel);               //set 0 Behaivior

        setDirectionF(roataDreapta, brat_S, brat_D, brat_A, peria, carusel);                            //set Directions Forward
        setDirectionR(roataStanga, brat_S);                                                             //set Directions Reverse

        setEncoders(useEncoders, roataStanga, roataDreapta, brat_S, brat_D, brat_A, peria, carusel);    //set encoders

        stopMotors();   //setPower 0
    }

    public void stopMotors() {
        roataStanga.setPower(0);
        roataDreapta.setPower(0);
        brat_S.setPower(0);
        brat_D.setPower(0);
        brat_A.setPower(0);
        peria.setPower(0);
        carusel.setPower(0);
    }

    public void stopMotors(DcMotor ... motors) {
        for (DcMotor m:motors)
            m.setPower(0);
    }

    public void goToPosition(double p, int r, DcMotor ... motors) {
        for (DcMotor m:motors){
            m.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            m.setTargetPosition(r);
            m.setPower(p);
            m.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }

    private void setEncoders(Boolean use, DcMotor ... motors) {
        if (use) {
            for (DcMotor m:motors) {
                m.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);  //Cu Encodere
                m.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            }
        }
        else for (DcMotor m:motors)
                 m.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);    //Fara Encodere
    }

    private void set0Behaviour(DcMotor ... motors) {
        for (DcMotor m:motors)
            m.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    private void setDirectionF(DcMotor ... motors) {
        for (DcMotor m:motors)
            m.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    private void setDirectionR(DcMotor ... motors) {
        for (DcMotor m:motors)
            m.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void runOpMode(){}
    public HardwareM(){}    //Constructor
}
