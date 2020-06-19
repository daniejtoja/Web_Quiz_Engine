package engine.answers;

public class Answer {
    private boolean success;
    private String feedback;

    public Answer(boolean succeed) {
        if(succeed) {
            this.success = true;
            this.feedback = "Congratualtions, you're right";
        } else {
            this.success = false;
            this.feedback = "Wrong answer! Please, try again";
        }
    }

    public Answer(boolean succeed, String feedback) {
        this(succeed);
        this.feedback = feedback;
    }

    public boolean getSuccess() {
        return success;
    }

    public Answer setSuccess(boolean success) {
        if(success){
            this.success = success;
            this.feedback = "Congratualtions, you're right";
            return this;
        } else {
            this.success = success;
            this.feedback = "Wrong answer! Please, try again";
            return this;
        }

    }

    public Answer setBoth(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
        return this;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}

