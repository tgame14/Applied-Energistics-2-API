package appeng.api.networking;

import appeng.api.networking.events.MENetworkEvent;

/**
 * Gives you access to Grid based information.
 * 
 * Don't Implement.
 */
public interface IGrid
{

	/**
	 * Get Access to various grid modules
	 * 
	 * @param iface
	 * @return the IGridCache you requested.
	 */
	public <C extends IGridCache> C getCache(Class<? extends IGridCache> iface);

	/**
	 * Post an event into the network event bus.
	 * 
	 * @param ev
	 *            - event to post
	 * @return returns ev back to original poster
	 */
	public MENetworkEvent postEvent(MENetworkEvent ev);

	/**
	 * Post an event into the network event bus, but direct it at a single node.
	 * 
	 * @param ev
	 *            event to post
	 * @return returns ev back to original poster
	 */
	public MENetworkEvent postEventTo(IGridNode node, MENetworkEvent ev);

	/**
	 * get a list of the diversity of classes, you can use this to better detect which machines your interested in,
	 * rather then iterating the entire grid to test them.
	 * 
	 * @return iterator of all available host types.
	 */
	public Iterable<Class<? extends IGridHost>> getMachinesClasses();

	/**
	 * Get machines on the network.
	 * 
	 * @param classofIGridHost
	 * @return iterator of all nodes belonging to hosts of specified class.
	 */
	public Iterable<IGridNode> getMachines(Class<? extends IGridHost> classofIGridHost);

	/**
	 * @return iterator for all nodes on the network, node visitors are prefered.
	 */
	Iterable<IGridNode> getNodes();

	/**
	 * @return the current grids status, returns true if the grid is ready and operating
	 */
	public boolean isReady();

	/**
	 * @return true if the last node has been removed from the grid.
	 */
	public boolean isEmpty();

}