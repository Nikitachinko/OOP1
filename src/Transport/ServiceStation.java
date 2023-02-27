package Transport;
import java.util.LinkedList;
import java.util.Queue;


public class ServiceStation  {
private Transport transport;
    private  Queue<Transport> queue = new LinkedList<>();

    public ServiceStation(){

    }
    public Queue<Transport>getQueue(){
        return queue;
    }

    public void addToQueue(Transport transport) throws TransportTypeException {
        if (transport.diagnostic()) {
            queue.offer(transport);
            System.out.println(transport.getBrand() + " " + transport.getModel() + " успешно добавлен в очередь на обслуживание");
        } else {
            System.out.println("Автобус" + transport.getBrand() + "" + transport.getModel() + "не нуждается в техобслуживании перед заездом");
        }
    }
      public void carryOutATechnicallnspecion(){
          System.out.println("Транспорт"+queue.poll()+"Успешно прошел техобслуживание");
      }

    public void makeDiagnostic() {
        Transport transport = queue.poll();
        if (transport != null) {
            System.out.println(transport.getBrand() + " " + transport.getModel() + " успешно прошел облуживание");
        } else
            System.out.println("Очередь на облуживание пуста");
    }

    @Override
    public String toString() {
        StringBuilder totalTransports = new StringBuilder();
        int count = 0;
        if (queue.peek() != null) {
            for (Transport ts : queue) {
                totalTransports.append(" #").append(++count).append(": ").append(ts.getBrand()).append(" ").append(ts.getModel()).append(" ");
            }
        }
        if (count == 0)
            return "'Очередь на обслуживиние пуста'";
        return totalTransports.toString();
    }
}
