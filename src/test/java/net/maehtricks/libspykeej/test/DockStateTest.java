package net.maehtricks.libspykeej.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import net.maehtricks.libspykeej.datatype.DockState;
import net.maehtricks.libspykeej.util.Communication;

import org.junit.Test;

public class DockStateTest {

	@Test
	public void testDockState() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Communication<DockState> dCom = new Communication<DockState>(DockState.class);
		dCom.sendOne(baos, DockState.DOCKED);
		baos.close();
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		DockState dockState = dCom.receiveOne(bais);
		System.out.println(dockState);
		
		dCom.sendOne(baos, DockState.UNDOCKED);
		bais = new ByteArrayInputStream(baos.toByteArray());
		dockState = dCom.receiveOne(bais);
	}

}
