

<?php $__env->startSection('title', 'Login'); ?>

<?php $__env->startSection('content'); ?>
    <!-- il wrapper è il contenitore che contiene il box della form di login -->
    <div class="wrapper wrapper-login">
        <!-- box che contiene la form di login -->
        <div class="form-box login">
            <h2>Login</h2>
            <!-- effettiva form di login -->
            <?php echo e(Form::open(array('route' => 'login', 'class' => 'contact-form'))); ?>


                <div class="input-box">
                    <?php echo e(Form::label('username', 'Username', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::text('username', '', ['class' => 'input','id' => 'username'])); ?>

                    <?php if($errors->first('username')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('username'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>
                </div>

                <div class="input-box">
                    <?php echo e(Form::label('password', 'Password', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::password('password', ['class' => 'input', 'id' => 'password'])); ?>

                    <?php if($errors->first('password')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('password'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>
                </div>

            <div class="container-form-btn">
                <?php echo e(Form::submit('Login', ['class' => 'btn'])); ?>

            </div>

                <div class="form-alt-container">
                    <p>
                        Non hai un account?&nbsp;&nbsp;<b><a href="<?php echo e(route('register')); ?>" class="form-alt-link">Registrati</a></b>
                    </p>
                </div>
            <?php echo e(Form::close()); ?>

        </div>
    </div>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.skel', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/auth/login.blade.php ENDPATH**/ ?>