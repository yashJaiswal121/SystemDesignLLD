package StrategyDP.DerekYoutubeExample;
//These implemetations are called Strategy
public class CannotFly implements ItFlys{
    @Override
    public void canFly() {
        System.out.println("It Cannot Fly");
    }
}
