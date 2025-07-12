class Solution {
    int cameras = 0;
    final int needCamera = -1, covered = 0, haveCamera = 1;

    int dfs(TreeNode root) {
        if (root == null) {
            return covered;
            /*
                So that leaf doesn't install camera on it
                Note: I will never assign camera to a leaf node.
                It will be better if I assign camera to that leaf's
                parent node, because parent will cover both its
                child as well it's own parent as well.
            */
        }

        int l = dfs(root.left);
        int r = dfs(root.right);

        if (l == 0 && r == 0) {
            /*
                I will tell my parent to cover me because my
                children are already covered. Installing camera
                on me will not be beneficial. Let my parent do that
                because my parent will cover me, my brother and
                my grandfather as well
            */
            return needCamera; // I need my parent to cover me by a camera on them
        }

        if (l == -1 || r == -1) {
            /*
                If any of my child wants me to put a camera on me,
                I will have to put a camera on myself. AND I will tell
                my parent that I have a camera. Not to worry
            */
            cameras++;
            return haveCamera;
        }

        if (l == 1 || r == 1) {
            /*
                If any of my child has a camera, I will
                be covered as well. So I will tell my parent
                that I am covered
            */
            return covered;
        }

        // don't worry about this case. control will never reach here
        return -1;
    }

    public int minCameraCover(TreeNode root) {
        /*
            status code  : what does that mean

            -1 : I need a camera to be covered
             0 : covered by either (child or parent)
             1 : I have a camera so I am covered as well
                 (but if my brother needs a camera my parent will
                 install camera on it)
        */
        cameras = 0;
        int status_of_root = dfs(root);
        /*
         Wait Wait, don't directly return cameras here.
         Just one thing you missed. Take a case as shown below
                    root
                    / \
                   /   \
                null  null
         null returns 1 and 1, i.e. they are covered.
         So, root will tell its parent to install a camera and it will
         return -1. But root has no parent. So this case will be missed.
         So, check the returned value of dfs here and see if it's -1
         then add one camera and then return cameras
        */
        if (status_of_root == needCamera)
            cameras++;
        return cameras;
    }
}
