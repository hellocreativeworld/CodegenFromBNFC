package CPP.Absyn; // Java Package generated by the BNF Converter.

public abstract class Program implements java.io.Serializable 
{
	private static final long serialVersionUID = -1572239725920440691L;

public abstract <R,A> R accept(Program.Visitor<R,A> v, A arg);
  
  public interface Visitor <R,A> 
  {
    public R visit(CPP.Absyn.PDefs p, A arg);

  }

}
