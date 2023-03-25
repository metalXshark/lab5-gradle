package commands.manager;

public enum CommandResult {

    ERROR_MASSAGE("#Error в комманде - "),
    SUCCESS_MASSAGE("Команда выполнена успешно!"),
    ERROR("#Error");

    private final String result;
    CommandResult(String result){
        this.result = result;
    }
    public String getResult(){
        return result;
    }
}
