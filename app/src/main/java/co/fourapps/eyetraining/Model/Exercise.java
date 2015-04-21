package co.fourapps.eyetraining.Model;

import co.fourapps.eyetraining.ExerciseProps;

/**
 * Created by mertsimsek on 19/11/14.
 */
public class Exercise {

    private String name;
    private boolean isDone;
    private String time;
    private boolean isHeader;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int[] getImgIds() {
        return imgIds;
    }

    public void setImgIds(int[] imgIds) {
        this.imgIds = imgIds;
    }

    private String desc;
    private int[] imgIds;

    public Exercise(String name, boolean isDone, String time, boolean isHeader) {
        this.name = name;
        this.isDone = isDone;
        this.time = time;
        this.isHeader = isHeader;
        this.imgIds = new int[0];

        if (name.equals("Distant Night")) {

            this.desc = ExerciseProps.distantNightDesc;
            this.imgIds = ExerciseProps.distantNightImgIds;

        } else if (name.equals("Ferris Wheel")) {

            this.desc = ExerciseProps.ferrisWheelDesc;
            this.imgIds = ExerciseProps.ferrisWheelImgIds;

        } else if (name.equals("3 Cups: Level 1")) {

            this.desc = ExerciseProps.threeCupsL1Desc;
            this.imgIds = ExerciseProps.threeCupsL1ImgIds;

        } else if (name.equals("3 Cups: Level 2a")) {

            this.desc = ExerciseProps.threeCupsL2ADesc;
            this.imgIds = ExerciseProps.threeCupsL2AImgIds;

        } else if (name.equals("3 Cups: Level 2b")) {

            this.desc = ExerciseProps.threeCupsL2BDesc;
            this.imgIds = ExerciseProps.threeCupsL2BImgIds;

        } else if (name.equals("3 Cups: Level 3a")) {

            this.desc = ExerciseProps.threeCupsL3ADesc;
            this.imgIds = ExerciseProps.threeCupsL3AImgIds;

        } else if (name.equals("3 Cups: Level 3b")) {

            this.desc = ExerciseProps.threeCupsL3BDesc;
            this.imgIds = ExerciseProps.threeCupsL3BImgIds;

        } else if (name.equals("Pinball")) {

            this.desc = ExerciseProps.pinballDesc;
            this.imgIds = ExerciseProps.pinballImgIds;

        } else if (name.equals("In & Out")) {

            this.desc = ExerciseProps.inOutL1Desc;
            this.imgIds = ExerciseProps.inOutL1ImgIds;

        } else if (name.equals("In & Out Level 2")) {

            this.desc = ExerciseProps.inOutL2Desc;
            this.imgIds = ExerciseProps.inOutL2ImgIds;

        } else if (name.equals("String Beads")) {

            this.desc = ExerciseProps.stringBeadsDesc;
            this.imgIds = ExerciseProps.stringBeadsImgIds;

        } else if (name.equals("Eyes Wide Open")) {

            this.desc = ExerciseProps.eyesWideOpenDesc;
            this.imgIds = ExerciseProps.eyesWideOpenImgIds;

        } else if (name.equals("Muscle Massage")) {

            this.desc = ExerciseProps.muscleMassageDesc;
            this.imgIds = ExerciseProps.muscleMassageImgIds;

        } else {

            this.desc = "Relax";

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean isHeader) {
        this.isHeader = isHeader;
    }
}
