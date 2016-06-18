package ua.teachme.util.maingoal;

import ua.teachme.dto.MainGoalTO;
import ua.teachme.model.MainGoal;
import ua.teachme.model.User;

public class MainGoalUtil {

    public static MainGoal updateMainGoal(User user, MainGoalTO mainGoalTO) {
        MainGoal mainGoal = user.getMainGoal();
        if (null != mainGoal) {
            update(mainGoal, mainGoalTO);
        }
        else {
            mainGoal = new MainGoal();
            mainGoal.setUser(user);
            user.setMainGoal(mainGoal);
            update(mainGoal, mainGoalTO);
        }
        return mainGoal;
    }

    private static void update(MainGoal mainGoal, MainGoalTO mainGoalTO){
        mainGoal.setName(mainGoalTO.getName());
        mainGoal.setDescription(mainGoalTO.getDescription());
    }
}
