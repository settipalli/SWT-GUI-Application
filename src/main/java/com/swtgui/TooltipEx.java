package com.swtgui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TooltipEx {


    public TooltipEx(Display display) {
        initUI(display);
    }

    private void initUI(Display display) {

        Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);

        shell.setText("Tooltip");
        shell.setToolTipText("This is a SWT window");
        shell.setSize(512, 512);

        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    public static void main(String[] args) {

        Display display = new Display();
        TooltipEx ex = new TooltipEx(display);
        display.dispose();
    }
}
