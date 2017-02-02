package CollectionsV2;


/** This interface defines the generic abstract data type list representing a
  * sequence of items that can be accessed by their relative position in the list.
  * Unless the cursor is off the end of the list, one list item (considered to be
  * the current item) is referenced by the cursor and operations are relative to
  * this item.
  *
  * @see NoSpaceException
  * @see NoItemException
  *
  * @author D. Hughes
  *
  * @version 1.0 (Jan. 2014)
  *
  * new concepts: cursored list                                                  */


public interface List < E > {
    
    
    /** This method adds an item to the list in front of the cursor. If the cursor
      * is off the end of the list, the insertion is at the end of the list. The
      * cursor references the item just added. NoSpaceException occurs if there is
      * no room to add another item.
      *
      * @param  item  the item to be added.
      *
      * @exception  NoSpaceException  no more room to add items.                 */
    
    public void add ( E item );
    
    
    /** This method removes the item at the cursor from the list. The cursor
      * references the item following the one removed. A NoItemException occurs if
      * the cursor was off the end of the list.
      *
      * @result  E  the item removed.
      *
      * @exception  NoItemException  no current item (cursor off list).          */
    
    public E remove ( );
    
    
    /** This method returns the item at the cursor. A NoItemException occurs if the
      * cursor was off the end of the list.
      *
      * @result  E  the item at the cursor.
      *
      * @exception  NoItemException  no current item (cursor off list).          */
    
    public E get ( );
    
    
    /** This method returns true if the list has no items.
      *
      * @return  boolean  the list has no items.                                 */
    
    public boolean empty ( );
    
    
    /** This method returns the number of items in the list.
      *
      * @result  int  the number of items in the list.                           */
    
    public int length ( );
    
    
    /** This method moves the cursor to the first item on the list. If the list is
      * empty, the cursor will be off the end of the list.                       */
    
    public void toFront ( );
    
    
    /** This method advances the cursor to the next item in the list. If the cursor
      * was off the list, it remains off the list.                               */
    
    public void advance( );
    
    
    /** This method indicates if the cursor is off the end of the list.
      *
      * @return  boolean  the cursor is off the end of the list.                 */
    
    public boolean offEnd ( );
    
    
} // List