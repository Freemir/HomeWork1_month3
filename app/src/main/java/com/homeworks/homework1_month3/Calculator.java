package com.homeworks.homework1_month3;

public class Calculator {

    private int firstArg;
    private int secondArg;

    private StringBuilder inputString = new StringBuilder();

    private int actionSelected;

    private State state;

    private enum State {
        firstArgInput,
        secondArgInput,
        resultShow,
    }

    public Calculator (){
        state = State.firstArgInput;

    }

    public void onNumPressed(int buttonId){

        if (state == State.resultShow){
            state = State.firstArgInput;
            inputString.setLength(0);
        }
        if (inputString.length() < 9){
            switch (buttonId){
                case R.id.zero:
                    if (inputString.length() != 0){
                        inputString.append("0");
                    }
                    break;
                case R.id.one:
                    inputString.append("1");
                    break;
                case R.id.two:
                    inputString.append("2");
                    break;
                case R.id.three:
                    inputString.append("3");
                    break;
                case R.id.four:
                    inputString.append("4");
                    break;
                case R.id.five:
                    inputString.append("5");
                    break;
                case R.id.six:
                    inputString.append("6");
                    break;
                case R.id.seven:
                    inputString.append("7");
                    break;
                case R.id.eight:
                    inputString.append("8");
                    break;
                case R.id.nine:
                    inputString.append("9");
                    break;
            }
        }
    }

    public void onActionPressed(int actionId){

        if (actionId == R.id.result && state == State.secondArgInput){
            secondArg = Integer.parseInt(inputString.toString());
            state = State.resultShow;
            inputString.setLength(0);
            switch (actionSelected){
                case R.id.multiply:
                    inputString.append(firstArg*secondArg);
                    break;
                case R.id.divide:
                    inputString.append(firstArg/secondArg);
                    break;
                case R.id.plus:
                    inputString.append(firstArg+secondArg);
                    break;
                case R.id.minus:
                    inputString.append(firstArg-secondArg);
                    break;
            }
        }else if (inputString.length() > 0 && state == State.firstArgInput){
            firstArg = Integer.parseInt(inputString.toString());
            state = State.secondArgInput;
            inputString.setLength(0);
            switch (actionId){
                case R.id.multiply:
                    actionSelected = R.id.multiply;
                    break;
                case R.id.divide:
                    actionSelected = R.id.divide;
                    break;
                case R.id.plus:
                    actionSelected = R.id.plus;
                    break;
                case R.id.minus:
                    actionSelected = R.id.minus;
                    break;
            }
        }

    }

    public String getText (){
        return inputString.toString();
    }


}
