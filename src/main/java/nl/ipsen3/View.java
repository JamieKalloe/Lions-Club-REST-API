package nl.ipsen3;

/**
 * Meer informatie over views:
 *  http://www.baeldung.com/jackson-json-view-annotation
 * 
 * @author Groep1>
 * @since 1.0
 */
public class View
{
    public static class Private extends Public {}
    
    public static class Public {}
    
    public static class Protected extends Public {}
}
