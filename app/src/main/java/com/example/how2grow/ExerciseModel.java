package com.example.how2grow;

public class ExerciseModel {
    String exerciseName;
    String exerciseSetup;
    String exerciseExecution;
    int image;

    public ExerciseModel(String exerciseName, String exerciseSetup, String exerciseExecution, int image) {
        this.exerciseName = exerciseName;
        this.exerciseSetup = exerciseSetup;
        this.exerciseExecution = exerciseExecution;
        this.image = image;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getExerciseSetup() {
        return exerciseSetup;
    }

    public String getExerciseExecution() {
        return exerciseExecution;
    }

    public int getImage() {
        return image;
    }
}
