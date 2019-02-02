package com.swtgui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MnemonicEx {
    public MnemonicEx(Display display) {

        initUI(display);
    }

    public static void main(String[] args) {

        Display display = new Display();
        MnemonicEx ex = new MnemonicEx(display);
        display.dispose();
    }

    private void initUI(Display display) {

        final Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);

        RowLayout layout = new RowLayout();
        layout.marginLeft = 30;
        layout.marginTop = 30;
        layout.marginBottom = 150;
        layout.marginRight = 150;

        shell.setLayout(layout);

        Button btn = new Button(shell, SWT.PUSH);
        btn.setText("&Button"); // Any character that is succeds '&' becomes a Mnemonic. Default modifier is Alt(Option). Alt+B activates the button.
        btn.setToolTipText("Displys a message");
        btn.setLayoutData(new RowData(80, 30));
        btn.addListener(SWT.Selection, event -> System.out.println("Button clicked."));
        btn.addListener(SWT.MouseHover, event -> System.out.println(String.format("Hovered over the button at (%d, %d).", event.x, event.y)));

        shell.setText("Mnemonic Button");
        shell.pack();
        shell.open();

        while (!shell.isDisposed())
            if (!display.readAndDispatch())
                display.sleep();
    }
}
